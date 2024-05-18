import React from "react";
import styles from "../styles/style1.module.css";

function Registraduria() {
    return (
        <div className={styles.body}>
            <div className={styles.formContainer}>

                <h2 className={styles.h2}>Registraduría Nacional del Estado Civil</h2>
                <p className={styles.p}>Ingrese sus datos personales</p>

                <form method="post" autoComplete="off" className={styles.form}>
                    <div className={styles.formGroup}>
                        <div className={styles.formContent}>
                            <label htmlFor="Documento" className={styles.label}>Tipo de Documento a tramitar</label>
                            <select name="Documento" className={styles.select}>
                                <option value="tarjeta" className={styles.option}>Tarjeta de Identidad</option>
                                <option value="cedula" className={styles.option}>Cédula de ciudadanía</option>
                                <option value="pasaporte" className={styles.pption}>Pasaporte</option>
                            </select>
                        </div>
                        <div className={styles.formContent}>        
                            <label htmlFor="NumeroIdentificacion" className={styles.label}>Numero de identificacion</label>
                            <input type="text" id="identificacion" name="identificacion" placeholder="Numero de Identificacion" required className={styles.input} /><br />
                        </div>
                    </div> 
                    <div className={styles.formGroup}>
                        <div className={styles.formContent}>   
                            <label htmlFor="Name" className={styles.label}>Nombres</label>
                            <input type="text" id="name" name="name" placeholder="Nombres" required className={styles.input} /><br />
                        </div>
                        <div className={styles.formContent}> 
                            <label htmlFor="apellidos" className={styles.label}>Apellidos</label>
                            <input type="text" id="apellidos" name="apellidos" placeholder="Apellidos" required className={styles.input} /><br />
                        </div>
                    </div>
                    <input className={styles.btn} type="submit" name="contact" value="Continuar" />
                </form>
            </div>
        </div>
    );
}

export default Registraduria;