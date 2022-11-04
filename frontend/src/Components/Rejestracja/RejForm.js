import React,{ useState } from "react";
import axios from "axios";
import "./RejForm.css";


export default function RejForm(){
    axios.defaults.withCredentials = true;


    return(
        <div className="card">
            <div  className={"formStyle"} onSubmit={"handleSubmit"}>
                <div >Rejestracja </div> <br/>
                <div >
                    <label className={"labelStyle"}>Imię:</label><br/>
                    <input className={"inputStyle"} /><br/>
                </div>
                <div >
                    <label className={"labelStyle"}> Nazwisko:</label><br/>
                    <input className={"inputStyle"} /><br/>
                </div>
                <div >
                    <label className={"labelStyle"} >Email:</label><br/>
                    <input className={"inputStyle"}  />
                </div>
                <div>

                    <label className={"labelStyle"}>Login:</label><br/>
                    <input className={"inputStyle"}  /><br/>
                </div>

                <div >
                    <label className={"labelStyle"}>Hasło:</label><br/>
                    <input type="password" className={"inputStyle"} /><br/>

                </div>
                <div >
                    <label className={"labelStyle"}>Potwierdź hasło:</label><br/>
                    <input type="password" className={"inputStyle"}/><br/>


                </div>


                <button className="button"type="submit">Zarejestruj</button>
            </div> </div>


    );
};