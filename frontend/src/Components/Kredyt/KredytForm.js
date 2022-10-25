import React from "react";
import axios from "axios";
import "./KredytForm.css"
export default function KredytForm(){
    axios.defaults.withCredentials = true;

    return(
    <div className={"cont"}>
        <div className={"gora"}>
            <h1>Minutówka</h1>
            <h2>Pożyczka jakiej potrzebujesz w minutę</h2> <br/>
            <h2>Nawet do 2000 zł</h2> <br/>
            <h2>RRSO: 0%</h2> <br/>
            <h3><button>Sprawdź swoją zdolność kredytową</button></h3><br/>
        </div>
        <div className={"dol"}>
            <div className={"zakladka"}>
                <a href={"pierwsza"} >Pierwsza pożyczka</a>
                <a  href={"kolejna"}>Kolejna pożyczka</a> <br/> <br/>
            </div>

                <div className={"tab"}>
                    <h1>Informacje:</h1>
                    Całkowity koszt pierwszej pożczyki 0zł <p/>
                    Pieniądze na koncie tego samego dnia <p/>
                    Oprocentowanie w skali roku 0% <p/>
                    Szybki wniosek składany online <p/>
                    Umowa na okres 30 dni <p/>

                </div>
                <div className={"tab1"}>
                    <h1>Pożyczka:</h1>
                    <h2>Podaj kwotę: <input/>zł </h2>

                    <h2>Czas trwania: 30 dni</h2>
                    <h2>Rata: 1500 zł</h2>
                    <h3><button>Weź pożyczkę</button></h3>
                </div>


        </div>


    </div>
)
}