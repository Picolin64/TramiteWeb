import React from "react";
import { instance as axios } from "../api/axios";

function Login(props) {
  const apiURL = "/tramiteweb/rest/usuario/login";

  const login = async (username, password) => {
    const response = await axios.post(
      apiURL,
      {
        "numero_identificacion": username,
        "contraseña": password
      },
      {
        headers: {
          "Content-Type": "application/json",
        },
      }
    );

    return response;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const form = e.target;
    const formData = new FormData(form);
    const formJson = Object.fromEntries(formData.entries());

    const user = formJson.user;
    const password = formJson.password;

    try {
      const response = await login(user, password);

      if (response.data === true) {
        props.auth(true);
        alert("Bienvenido.");
      } else {
        alert("Error en las credenciales.")
      }
    } catch (error) {
      console.error(error);
      alert("Error en la conexion.");
    }
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <label>
          Usuario
          <input type="text" name="user" />
        </label>
        <label>
          Contraseña
          <input type="password" name="password" />
        </label>
        <button type="submit">Ingresar</button>
      </form>
    </div>
  );
}

export default Login;
