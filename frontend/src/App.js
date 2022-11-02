import ZdolnoscKredFrom from "./Components/ZdolnoscKredytowa/ZdolnoscKredForm"
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import KredytForm from "./Components/Kredyt/KredytForm"
import KontaktForm from "./Components/Kontakt/KontaktForm";
import PomocForm from "./Components/Pomoc/PomocForm";
import RegulaminForm from "./Components/Regulamin/RegulaminForm";

function App() {
  return (
      <div className="App">
          <Router>
              <Routes>
                  <Route path={"/formularz-zdolnosci-kredytowej"} element={<ZdolnoscKredFrom/>}/>
                  <Route path={"/strona-wez-kredyt"} element={<KredytForm/>}/>
                  <Route path={"/kontakt"} element={<KontaktForm/>}/>
                  <Route path={"/pomoc"} element={<PomocForm/>}/>
                  <Route path={"/regulamin"} element={<RegulaminForm/>}/>
              </Routes>
          </Router>
      </div>
  );
}

export default App;