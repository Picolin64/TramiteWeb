import React from "react";
import styles from "../styles/style1.module.css";

function CitaRegistraduria() {
    return (
        <div className={styles.body}>
            <div className={styles.formContainer}>

                <h2 className={styles.h2}>Información de Citación</h2>

                <form method="post" autoComplete="off" className={styles.form}>
                    <div className={styles.formGroup}>
                        <label htmlFor="Name" className={styles.label}>Tipo de documento a tramitar</label>
                        <label htmlFor="Name" className={styles.label}>Numero de identificacion</label>
                        <label htmlFor="Name" className={styles.label}>Nombres</label>
                        <label htmlFor="Name" className={styles.label}>Apellidos</label>
                        <label htmlFor="Name" className={styles.label}>Direccion de sede de Registraduría</label>
                        <label htmlFor="Name" className={styles.label}>Fecha</label>
                        <label htmlFor="Name" className={styles.label}>Hora</label>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default CitaRegistraduria;