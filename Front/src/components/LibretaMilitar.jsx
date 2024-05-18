import React from "react";
import styles from "../styles/style2.module.css";

function LibretaMilitar(){
    return (
        <div className={styles.body}>
            <div className={styles.formContainer}>
                <h2 className={styles.h2}>Libreta Militar</h2>
                <p className={styles.p2}>Ingrese sus datos personales</p>
                <form method="post" autoComplete="off" className={styles.form}>
                    <div className={styles.formGroup}>
                        <div className={styles.formContent}>
                            <label htmlFor="Cita" className={styles.label}>Solicitar cita para</label>
                            <select name="Cita" className={styles.select}>
                                <option value="presentar" className={styles.option}>Presentar documentacion</option>
                                <option value="reclamar" className={styles.option}>Reclamar libreta militar</option>
                            </select>
                        </div>
                        <div className={styles.formContent}>        
                            <label htmlFor="NumeroIdentificacion" className={styles.label}>Numero de Identificacion</label>
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
                    <input type="submit" name="contact" value="Continuar" className={styles.btn} />
                </form>
            </div>
        </div>
    );
}

export default LibretaMilitar;