import React,{ useState } from "react";
import axios from "axios";
import "./RejForm.css";
import {useNavigate} from "react-router-dom";


export default function RejForm(){
    let navigate = useNavigate();
    const [imie, setImie] = useState();
    const [nazwisko, setNazwisko] = useState();
    const [email, setEmail] = useState();
    const [haslo, setHaslo] = useState();
    const [login, setLogin] = useState();
    const [pothas, setPothas] = useState();

    function sendFrom(){
        axios.post("http://localhost:8080/uzytkownik/rejestracja", {
                imie: imie,
                nazwisko: nazwisko,
                email: email,
                haslo:haslo,
                login:login,
            }
        ).then((response) => {
            console.log(response.data)
            if(response.data==="POSITIVE"){
                window.alert("Założyłeś Konto :).");
                navigate('/Login');
            }else{
                window.alert("wystąpił błąd :( .");

            }
        })
    }
    const [messEm, setmessEm] = useState( false)

    function wEmail(n){
        if(!n){
            setmessEm("(E-mail jest wymagany)")
        }else if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(n)) {
            setmessEm("(Zły format adresu)")
        }
        else {
            setEmail(n)
            setmessEm (null)
        }
    }

    return(
        <div className="Card">
            <div  className={"formStyle"} onSubmit={"handleSubmit"}>
                <div >Rejestracja </div> <br/>
                <div >
                    <label className={"labelStyle"}>Imię:</label><br/>
                    <input className={"inputStyle"} onChange={(v)=>setImie(v.target.value)} /><br/>
                </div>
                <div >
                    <label className={"labelStyle"}> Nazwisko:</label><br/>
                    <input className={"inputStyle"}onChange={(v)=>setNazwisko(v.target.value)} /><br/>
                </div>
                <div >
                    <label className={"labelStyle"} >Email:</label><br/>
                    <input className={"inputStyle"} onChange={(v)=>wEmail(v.target.value)} />
                </div>
                <div>

                    <label className={"labelStyle"}>Login:</label><br/>
                    <input className={"inputStyle"}onChange={(v)=>setLogin(v.target.value)}  /><br/>
                </div>

                <div >
                    <label className={"labelStyle"}>Hasło:</label><br/>
                    <input type="password" className={"inputStyle"}onChange={(v)=>setHaslo(v.target.value)} /><br/>

                </div>
                <div >
                    <label className={"labelStyle"}>Potwierdź hasło:</label><br/>
                    <input type="password" className={"inputStyle"}onChange={(v)=>setPothas(v.target.value)}/><br/>


                </div>


                <button className="button" onClick={sendFrom}>Zarejestruj</button>
            </div> </div>


    );
};