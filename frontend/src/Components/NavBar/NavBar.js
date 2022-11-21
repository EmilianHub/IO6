import React, {useState, useEffect} from 'react';
import {NavBarData, NavBarDataUser} from "./NavBarData";
import {Link} from "react-router-dom";
import "./NavBar.css"
import {readCookie} from "../CookiesManager/CookiesManager"

const Navbar = () => {
    const userId = readCookie();
    const [navBar, setNavBar] = useState([]);

    useEffect(() => {
        if(!userId){
            setNavBar(NavBarData)
        }else {
            setNavBar(NavBarDataUser)
        }
    })

    return (
        <nav className={"NavBarItems"}>
            <h1 className={"Logo"}>
                Minutówka
            </h1>
            <ul className={"items-nav"}>
                    {navBar.map((key, value) => {
                        return (
                        <li key={value}>
                            <Link to= {key.link} className={"nav-text"}>
                            {key.img} {key.name}
                            </Link>
                        </li>
                        );
                    })
                    }
            </ul>
        </nav>
    );
};

export default Navbar;