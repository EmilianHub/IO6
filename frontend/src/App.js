import ZdolnoscKredFrom from "./Components/ZdolnoscKredytowa/ZdolnoscKredForm"
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import KredytForm from "./Components/Kredyt/KredytForm"

function App() {
  return (
      <div className="App">
          <Router>
              <Routes>
                  <Route path={"/formularz-zdolnosci-kredytowej"} element={<ZdolnoscKredFrom/>}/>
                  <Route path={"/strona-wez-kredyt"} element={<KredytForm/>}/>
              </Routes>
          </Router>
      </div>
  );
}

export default App;