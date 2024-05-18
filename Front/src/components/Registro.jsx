import React from "react";
import { instance as axios } from "../api/axios";
import styles from "../styles/styles.module.css";

function Registro(){
    const apiURL = "/tramiteweb/rest/usuario/register";

    const registrar = async (numeroIdentificacion, nombres, apellidos, contraseña) => {
        const response = await axios.post(
        apiURL,
        {
            "numero_identificacion": numeroIdentificacion,
            "nombres": nombres,
            "apellidos": apellidos,
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
        const nombres = formJson.nombres.toUpperCase();
        const apellidos = formJson.apellidos.toUpperCase();
        const contraseña = formJson.contraseña;

        try {
        const response = await registrar(numeroIdentificacion, nombres, apellidos, contraseña);
            if (response.data.estado === "exito") {
                alert("Usuario registrado.");
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
                <h2 className={styles.h2}>Registro</h2>
                <input type="text" placeholder="Numero de Identificacion" name="numeroIdentificacion" className={styles.input} />
                <input type="text" placeholder="Nombres" name="nombres" className={styles.input} />
                <input type="text" placeholder="Apellidos" name="apellidos" className={styles.input} />
                <input type="password" placeholder="Contraseña" name="contraseña" className={styles.input} />
                <input type="password" placeholder="Confirma Contraseña" className={styles.input} />

                <input type="submit" value="Enviar" className={styles.btn} />
            </form>
        </div>
    );
}

export default Registro;