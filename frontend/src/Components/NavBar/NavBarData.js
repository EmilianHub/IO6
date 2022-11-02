import HomeIcon from '@mui/icons-material/Home';
import LoginIcon from '@mui/icons-material/Login';
import Register from '@mui/icons-material/AppRegistration';

export const NavBarData = [
    {
        name: "Strona Główna",
        img: <HomeIcon/>,
        link: "/"
    },
    {
        name: "Pożyczki",
        img: <HomeIcon/>,
        link: "/formularz-zdolnosci-kredytowej",
    },
    {
        name: "Login",
        img: <LoginIcon/>,
        link: "/Login"
    },
    {
        name: "Rejestracja",
        img: <Register/>,
        link: "/Register"
    }
];