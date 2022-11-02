import React from "react";
import axios from "axios";
import "./KredytForm.css";
import MoneyIcon from '@mui/icons-material/Money';
import AccessTimeIcon from '@mui/icons-material/AccessTime';
import LocalAtmIcon from '@mui/icons-material/LocalAtm';
import CardGiftcardIcon from '@mui/icons-material/CardGiftcard';
import PriceCheckIcon from '@mui/icons-material/PriceCheck';
import * as PropTypes from "prop-types";
import { CFormCheck } from '@coreui/react'


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
                <a href={"kalkulator"}>Kalkulator</a>
                <a href={"/pomoc"}>Pomoc</a>
                <a  href={"pierwsza"} >Pierwsza pożyczka</a>
                <a  href={"/formularz-zdolnosci-kredytowej"}>Kolejna pożyczka</a>
                <a href={"/kontakt"}>Kontakt</a>
                <a href={"/regulamin"}>Regulamin</a> <br/>
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
                    <h2>Podaj kwotę: <br/>
                    <CFormCheck button={{ color: 'secondary' }} type="radio" name="options-outlined" id="option1" autoComplete="off" label="500zł" defaultChecked/>
                    <CFormCheck button={{ color: 'secondary' }} type="radio" name="options-outlined" id="option2" autoComplete="off" label="700zł"/>
                    <CFormCheck button={{ color: 'secondary' }} type="radio" name="options-outlined" id="option3" autoComplete="off" label="1000zł" />
                    <CFormCheck button={{ color: 'secondary' }} type="radio" name="options-outlined" id="option4" autoComplete="off" label="1200zł"/>
                    <CFormCheck button={{ color: 'secondary' }} type="radio" name="options-outlined" id="option5" autoComplete="off" label="1500zł"/>
                    <CFormCheck button={{ color: 'secondary' }} type="radio" name="options-outlined" id="option6" autoComplete="off" label="1700zł"/>
                    <CFormCheck button={{ color: 'secondary' }} type="radio" name="options-outlined" id="option7" autoComplete="off" label="2000zł"/>
                    <br/>Czas trwania: 30 dni <br/>
                    Rata: 1600 zł</h2>
                    <h3><button>Weź pożyczkę</button></h3>
                </div>


        </div>


    </div>
)}
