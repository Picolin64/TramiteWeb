import React from "react";
import { instance as axios } from "../api/axios";
import styles from "../styles/style4.module.css";

function InicioSesion() {
    const apiURL = "/tramiteweb/rest/usuario/login";

    const iniciarSesion = async (numeroIdentificacion, contraseña) => {
        const response = await axios.post(
        apiURL,
        {
            "numero_identificacion": numeroIdentificacion,
            "contraseña": contraseña
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

        const numeroIdentificacion = formJson.numeroIdentificacion;
        const contraseña = formJson.contraseña;

        try {
        const response = await iniciarSesion(numeroIdentificacion, contraseña);
            if (response.data.estado === "exito") {
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
        <div className={styles.body}>
            <form onSubmit={handleSubmit} className={styles.form}>
                <h2 className={styles.h2}>Inicio de sesión</h2>
                <label htmlFor="identificacion" className={styles.label}>Numero de Identificacion</label>
                <input type="text" id="identificacion" name="numeroIdentificacion" className={styles.input} />
            
                <label htmlFor="password" className={styles.label}>Contraseña</label>
                <input type="password" id="password" name="contraseña" className={styles.input} />
            
                <input type="submit" className={styles.btn1} />
            </form>
        </div>
        
    );
}

export default InicioSesion;