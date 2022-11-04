import React,{ useState } from "react";
import axios from "axios";
import "./LogForm.css"
import {useNavigate} from "react-router-dom";


export default function LogForm(){
    axios.defaults.withCredentials = true;
    let navigate = useNavigate();
    const [haslo, setHaslo] = useState();
    const [login, setLogin] = useState();
    axios.post("http://localhost:8080/uzytkownik/logowanie", {
            haslo:haslo,
            login:login,
        }
    ).then((response) => {
        console.log(response.data)
        if (response.data === 0) {
            window.alert(("złe dane"))
        } else {
            navigate("./")

        }
    })

    return(
        <div className="Card1">
            <div  className={"formStyle1"} onSubmit={"handleSubmit"}>
                <div >Logowanie </div> <br/>
                <div>

                    <label className={"labelStyle1"}>Login:</label><br/>
                    <input className={"inputStyle1"} onChange={(v)=>setLogin(v.target.value)} /><br/>
                </div>

                <div >
                    <label className={"labelStyle1"}>Hasło:</label><br/>
                    <input type="password" className={"inputStyle1"} onChange={(v)=>setHaslo(v.target.value)}/><br/>
                </div>

                <button className="button1"type="submit">Zaloguj</button>
            </div> </div>


    );
}