import React,{ useState } from "react";
import axios from "axios";
import "./LogForm.css"


export default function LogForm(){
    axios.defaults.withCredentials = true;


    return(
        <div className="Card1">
            <div  className={"formStyle1"} onSubmit={"handleSubmit"}>
                <div >Logowanie </div> <br/>
                <div>

                    <label className={"labelStyle1"}>Login:</label><br/>
                    <input className={"inputStyle1"}  /><br/>
                </div>

                <div >
                    <label className={"labelStyle1"}>Hasło:</label><br/>
                    <input type="password" className={"inputStyle1"} /><br/>
                </div>

                <button className="button1"type="submit">Zaloguj</button>
            </div> </div>


    );
}