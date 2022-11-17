import React, {useState} from "react";
import axios from "axios";
import {useNavigate, useLocation} from "react-router-dom";
import {readCookie} from "../CookiesManager/CookiesManager"

export default function ZdolnoscKredForm(){
    let navigate = useNavigate();
    const { state } = useLocation();
    const userId = readCookie();
    const [zarobki, setZarobki] = useState(3000);
    const [raty, setRaty] = useState(0);
    const [wydatki, setWydaki] = useState(1500);

    function sendFrom(){

    }

    return(
        <div className={"Formularz"}>
            <div className={"Opis"}>
                <h2>Formularz określający zdolność kredytową</h2>
                <p>Poprzez wypełnienie formularza, zostanie wyliczona maksymalna kwota pożczyki. Pamiętaj aby dane podawać zgodnie z prawdą.
                    Dane nie zostaną nigdzie udostępnione.</p>
            </div>
            <div>
                <h2>Przychody i koszty utrzymania</h2>
                <div className={"Kontyner"}>
                    <fieldset>
                        <label className={"DochodLabel"}>Dochód netto</label>
                        <input className={"DochodInput"} type={"text"}
                               defaultValue={zarobki} onChange={(value) => setZarobki(value.target.value)}/>
                        <div className={"Desc"}>Kwota na rękę bez podatku</div>
                    </fieldset>
                    <fieldset>
                        <label className={"DochodLabel"}>Suma rat innych kredytów</label>
                        <input className={"DochodInput"} type={"text"} defaultValue={raty} onChange={(value) => setRaty(value.target.value)}/>
                        <div className={"Desc"}>Pole nieobowiązkowe</div>
                    </fieldset>
                    <fieldset>
                        <label className={"DochodLabel"}>Suma kosztów utrzymania</label>
                        <input className={"DochodInput"} type={"text"} defaultValue={wydatki} onChange={(value) => setWydaki(value.target.value)}/>
                        <div className={"Desc"}>Np. czynsz, zakupy</div>
                    </fieldset>
                </div>
                <button className={"SubmitButton"} onClick={sendFrom}>Oblicz</button>
            </div>
        </div>
    )
}