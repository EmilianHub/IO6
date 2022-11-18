import ZdolnoscKredFrom from "./Components/ZdolnoscKredytowa/ZdolnoscKredForm"
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import KredytForm from "./Components/Kredyt/KredytForm"
import KontaktForm from "./Components/Kontakt/KontaktForm";
import PomocForm from "./Components/Pomoc/PomocForm";
import RegulaminForm from "./Components/Regulamin/RegulaminForm";
import WarunkiForm from "./Components/Kontakt/Warunki";
import NavBar from "./Components/NavBar/NavBar";
import RejForm from "./Components/Rejestracja/RejForm";
import LogForm from "./Components/Logowanie/LogForm";
import ProfilForm from "./Components/Profil/ProfilForm";
import DaneKredytowe from "./Components/DaneKredytowe/DaneKredytowe"
import Logout from "./Components/Logout"
import PanelUzyForm from "./Components/PanelUzyForm/PanelUzyFomr"

function App() {
  return (
      <div className="App">
          <Router>
              <NavBar/>
              <Routes>
                  <Route path="/" exact element/>
                  <Route path={"/formularz-zdolnosci-kredytowej"} element={<ZdolnoscKredFrom/>}/>
                  <Route path={"/strona-wez-kredyt"} element={<KredytForm/>}/>
                  <Route path={"/kontakt"} element={<KontaktForm/>}/>
                  <Route path={"/pomoc"} element={<PomocForm/>}/>
                  <Route path={"/regulamin"} element={<RegulaminForm/>}/>
                  <Route path={"/warunki"} element={<WarunkiForm/>}/>
                  <Route path={"/Register"} element={<RejForm/>}/>
                  <Route path={"/Login"} element={<LogForm/>}/>
                  <Route path={"/profil"} element={<ProfilForm/>}/>
                  <Route path={"/kredyt-podsumowanie"} element={<DaneKredytowe/>}/>
                  <Route path={"/Logout"} element={<Logout/>}/>
                  <Route path={"/PanelUzy"} element={<PanelUzyForm/>}/>
              </Routes>
          </Router>
      </div>
  );
}

export default App;