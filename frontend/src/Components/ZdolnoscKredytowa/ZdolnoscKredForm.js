import React, {useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import "./ZdolnoscKredForm.css"
import PozyczkiClass from "../Classes/PozyczkiClass"
import {format} from "date-fns";

export default function ZdolnoscKredForm(){
    let navigate = useNavigate();
    let date = new Date(Date.now())
    let date2 = new Date(Date.now())
    date2.setMonth(date2.getMonth() + 12)
    const pozyczki = new PozyczkiClass(5000, date, date2);

    console.log(pozyczki)

    const [zarobki, setZarobki] = useState(3000);
    const [raty, setRaty] = useState(0);
    const [wydatki, setWydaki] = useState(1500);

    function sendFrom(){
        axios.post("http://localhost:8080/zdolnosc-kredytowa/process", {
                kwotaPozyczki: pozyczki.kwotaPozyczki,
                poczatekPozyczki: format(pozyczki.dataZaciagnieciaPozyczki, 'yyyy-dd-MM HH:mm:ss').toString(),
                zakonczeniePozyczki: format(pozyczki.dataZakonczeniaPozyczki, 'yyyy-dd-MM HH:mm:ss').toString()
            }, {
            params:{
                wydatki,
                raty,
                zarobki
            }}
        ).then((response) => navigate('/kredyt-podsumowanie/' + response.data))
    }

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
                <button type={"submit"} className={"SubmitButton"} onClick={() => sendFrom()}>Oblicz</button>
            </form>
        </div>
    )
}