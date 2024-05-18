import React from "react";
import CitaLibretaMilitar from "./components/CitaLibretaMilitar";
import CitaRegistraduria from "./components/CitaRegistraduria";
import InicioSesion from "./components/InicioSesion";
import LibretaMilitar from "./components/LibretaMilitar";
import Registraduria from "./components/Registraduria";
import Registro from "./components/Registro";
import Index from "./components/Index";
import Menu from "./components/Menu"

function App() {
  const [auth, setAuth] = React.useState(false);

  return <LibretaMilitar />
}

export default App;
