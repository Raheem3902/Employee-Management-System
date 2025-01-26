import "./App.css";
import EmployeeComponents from "./components/EmployeeComponents";
import FooterComponent from "./components/FooterComponents";
import HeaderComponent from "./components/HeaderComponents";
import ListEmployeeComponent from "./components/ListEmployeeComponents";
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
    <>
      <BrowserRouter>
        <HeaderComponent />

        <Routes>
          {/* // http://localhost:3000 */}
          <Route path="/" element={<ListEmployeeComponent />}></Route>
          {/* // http://localhost:3000/employees */}
          <Route path="/employees" element={<ListEmployeeComponent />}></Route>
          {/* // http://localhost:3000/add-employees */}
          <Route path="/add-employee" element={<EmployeeComponents />}></Route>
          {/* // http://localhost:3000/add-employees/1 */}
          <Route
            path="/edit-employee/:id"
            element={<EmployeeComponents />}
          ></Route>
        </Routes>

        <FooterComponent />
      </BrowserRouter>
    </>
  );
}

export default App;
