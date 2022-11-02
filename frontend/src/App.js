import ZdolnoscKredFrom from "./Components/ZdolnoscKredytowa/ZdolnoscKredForm"
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import NavBar from "./Components/NavBar/NavBar"

function App() {
  return (
      <div className="App">
          <Router>
              <NavBar/>
              <Routes>
                  <Route path={"/formularz-zdolnosci-kredytowej"} element={<ZdolnoscKredFrom/>}/>
              </Routes>
          </Router>
      </div>
  );
}

export default App;