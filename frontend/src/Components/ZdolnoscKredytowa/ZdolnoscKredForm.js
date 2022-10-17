import React, {useEffect, useState} from "react";
import {useForm} from "react-hook-form";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import "./ZdolnoscKredForm.css"

export default function ZdolnoscKredForm(){
    axios.defaults.withCredentials = true;


    return(
        <div className={"Formularz"}>
            <div className={"Opis"}>
                <h2>Formularz określający zdolność kredytową</h2>
                <p>Poprzez wypełnienie formularza, zostanie wyliczona maksymalna kwota pożczyki. Pamiętaj aby dane podawać zgodnie z prawdą.
                Dane nie zostaną nigdzie udostępnione.</p>
            </div>
            <form action={"#"}>
                <h2>Przychody i koszty utrzymania</h2>
                <div className={"Kontyner"}>
                    <fieldset>
                        <label className={"DochodLabel"}>Dochód netto</label>
                        <input className={"DochodInput"} type={"text"} inputMode={"numeric"} defaultValue={3000} value={"3000 zł"} pattern={"\d"} autoComplete={"off"}/>
                        <div className={"Desc"}>Kwota na rękę bez podatku</div>
                    </fieldset>
                    <fieldset>
                        <label className={"DochodLabel"}>Suma rat innych kredytów</label>
                        <input className={"DochodInput"} type={"text"} inputMode={"numeric"} defaultValue={0} value={"0 zł"} pattern={"\d"} autoComplete={"off"}/>
                        <div className={"Desc"}>Pole nieobowiązkowe</div>
                    </fieldset>
                    <fieldset>
                        <label className={"DochodLabel"}>Suma kosztów utrzymania</label>
                        <input className={"DochodInput"} type={"text"} inputMode={"numeric"} defaultValue={1500} value={"1500 zł"} pattern={"\d"} autoComplete={"off"}/>
                        <div className={"Desc"}>Np. czynsz, zakupy</div>
                    </fieldset>
                </div>
                <button type={"submit"} className={"SubmitButton"}>Oblicz</button>
            </form>
        </div>
    )
}