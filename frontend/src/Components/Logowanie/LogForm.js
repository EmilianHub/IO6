import React,{ useState } from "react";
import axios from "axios";
import "./LogForm.css";


export default function LogForm(){
    axios.defaults.withCredentials = true;


    return(
        <div className="card">
            <div  className={"formStyle"} onSubmit={"handleSubmit"}>
                <div >Logowanie </div> <br/>
                <div>

                    <label className={"labelStyle"}>Login:</label><br/>
                    <input className={"inputStyle"}  /><br/>
                </div>

                <div >
                    <label className={"labelStyle"}>Hasło:</label><br/>
                    <input type="password" className={"inputStyle"} /><br/>
                </div>

                <button className="button"type="submit">Zaloguj</button>
            </div> </div>


    );
}