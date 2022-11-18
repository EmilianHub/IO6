import React, {useEffect, useState} from "react";
import Axios from "axios";
import "./PanelUzyForm.css"
import EditIcon from '@mui/icons-material/Edit';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import {readCookie} from "../CookiesManager/CookiesManager";

export default function Useredd(){

    const UserID = readCookie();
    const [ShowUseres, setShowUseres] = useState([]);
    const [isEdited, setisEdited] = useState(false);
    const [Imie, setImie] = useState("");
    const [Nazwisko, setNazwisko] = useState("");
    const [Login, setLogin] = useState("");
    const [Haslo, setHaslo] = useState("");
    const [Email, setEmail] = useState("");
    const [Pesel, setPesel] = useState("");
    const [NrDowodu, setNrDowodu] = useState("");
    const [SelectedID, setSelectedID] = useState("");

    function HandelEdit(id){
        // eslint-disable-next-line array-callback-return
        ShowUseres.map((val, key) => {
            if(val.ID_log === id)
            {
                setSelectedID(val.id);
                setImie(val.imie);
                setNazwisko(val.nazwisko);
                setLogin(val.login);
                setHaslo(val.haslo);
                setEmail(val.email);
                setNrDowodu(val.nrDowodu);
                setPesel(val.pesel);

            }
        })
        setisEdited(true);
    }

    function Save() {
        Axios.post('http://localhost:8080/UpdateDanePV', {
            nrDowodu: NrDowodu.toString(),
            pesel: Pesel.toString(),
            uzytkownik:{
                id:parseFloat(UserID),
                imie: Imie.toString(),
                nazwisko: Nazwisko.toString(),
                email: Email.toString(),
                login: Login.toString(),
            }
        }).then((response)=>{
            if(response){
                setShowUseres(response.data)
            }
        })
    }

    function Anuluj(){
        setisEdited(false);
        setSelectedID(null);
        setImie(null);
        setNazwisko(null);
        setLogin(null);
        setHaslo(null);
        setEmail(null);
        setPesel(null);
        setNrDowodu(null);
    }
    useEffect(()=>{

    })

    function get(){
        Axios.get(`http://localhost:8080/Dane/${UserID}`).then(response=>{
            ShowUseres.push(response.data)
        })
    }
    console.log(ShowUseres)
    return(
        <div className="Foremka">
            {ShowUseres.length ? <TableContainer component={Paper}>
                <Table aria-label="simple table">
                    <TableHead className="TableAdmin">
                        <TableRow>
                            <TableCell className="Naglowek" align="center">Imię</TableCell>
                            <TableCell className="Naglowek" align="center">Nazwisko</TableCell>
                            <TableCell className="Naglowek" align="center">Login</TableCell>
                            <TableCell className="Naglowek" align="center">Email</TableCell>
                            <TableCell className="Naglowek" align="center">NrDowodu</TableCell>
                            <TableCell className="Naglowek" align="center">Edytuj</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {isEdited === true ?
                            <TableRow>
                                <TableCell className="TableAdminCell"><input className="EditInput" defaultValue={Imie} onChange={(e)=>setImie(e.target.value)}/></TableCell>
                                <TableCell className="TableAdminCell"><input className="EditInput" defaultValue={Nazwisko} onChange={(e)=>setNazwisko(e.target.value)}/></TableCell>
                                <TableCell className="TableAdminCell"><input className="EditInput" defaultValue={Login} onChange={(e)=>setLogin(e.target.value)}/></TableCell>
                                <TableCell className="TableAdminCell"><input className="EditInput" defaultValue={Email} onChange={(e)=>setEmail(e.target.value)}/></TableCell>
                                <TableCell className="TableAdminCell"><input id="PeselInput" defaultValue={Pesel} onChange={(e)=>setPesel(e.target.value)}/></TableCell>
                                <TableCell className="TableAdminCell"><input id="EditInput" defaultValue={NrDowodu} onChange={(e)=>setNrDowodu(e.target.value)}/></TableCell>
                                <TableCell className="TableAdminCell"><button id="ActionButtonSave" onClick={()=>{Save()}}>Zapisz</button></TableCell>
                                <TableCell className="TableAdminCell"><button id="ActionButtonAnuluj" onClick={()=>{Anuluj()}}>Anuluj</button></TableCell>
                            </TableRow> : "" }
                        <TableRow>
                            <TableCell>
                                {ShowUseres.toString()}
                            </TableCell>
                        </TableRow>
                    </TableBody>
                </Table>
            </TableContainer> : ""}

            {ShowUseres.length && ShowUseres[0].pesel.toString()}
            <button onClick={get}>Clike mE</button>
        </div>
    )
}