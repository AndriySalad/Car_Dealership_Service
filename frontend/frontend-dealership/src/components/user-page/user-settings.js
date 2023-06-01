import React, {useState} from "react";
import axios from "axios";

function UserSettings({user}) {
    const token = sessionStorage.getItem("token");
    const [firstName, setFirstName] = useState(user.firstName);
    const [lastName, setLastName] = useState(user.lastName);
    const [name, setName] = useState(user.name);
    const [email, setEmail] = useState(user.email);
    const [phoneNumber, setPhone] = useState(user.phoneNumber);

    const handleChangeInfo = async (e) => {
        e.preventDefault();
        const formData = {
            firstName,
            lastName,
            name,
            email,
            phoneNumber
        };
        axios.put("http://localhost:8080/users/profile/save-settings", formData, {
            headers: {
                Authorization: `Bearer ${token}`
            }
        }).then((response) => {
            setFirstName(response.data.firstName);
            setLastName(response.data.lastName);
            setName(response.data.name);
            setEmail(response.data.email);
            setPhone(response.data.phoneNumber);
            alert("Дані успішно змінені!")
        }).catch(error => alert("Ой, щойсь пішло не так..."))
    }


    return(
        <form className="user-setting" onSubmit={handleChangeInfo}>					
            <div className="cs-field-holder">
                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <label>Ім'я</label>
                </div>
                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div className="cs-field">
                        <input
                            type="text"
                            placeholder=""
                            value={firstName}
                            onChange={(e) => setFirstName(e.target.value)}
                        />
                    </div>
                </div>
            </div>
            <div className="cs-field-holder">
                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <label>Прізвище</label>
                </div>
                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div className="cs-field">
                        <input
                            type="text"
                            placeholder=""
                            value={lastName}
                            onChange={(e) => setLastName(e.target.value)}
                        />
                    </div>
                </div>
            </div>
            <div className="cs-field-holder">
                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <label>Нікнейм</label>
                </div>
                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div className="cs-field">
                        <input
                            type="text"
                            placeholder=""
                            value={name}
                            onChange={(e) => setName(e.target.value)}
                        />
                    </div>
                </div>
            </div>
            <div className="cs-field-holder">
                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <label>Електронна адреса</label>
                </div>
                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div className="cs-field">
                        <input
                            type="text"
                            placeholder=""
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                        />
                    </div>
                </div>
            </div>
            <div className="cs-field-holder">
                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <label>Номер мобільного телефону</label>
                </div>
                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div className="cs-field">
                        <input
                            type="text"
                            placeholder=""
                            value={phoneNumber}
                            onChange={(e) => setPhone(e.target.value)}
                        />
                    </div>
                </div>
            </div>
            <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div className="cs-seprator"></div>
            </div>
            <div className="cs-field-holder">
                <div className="col-lg-4 col-md-4 col-sm-12 col-md-12">
                    <div className="cs-field"><div className="cs-btn-submit"><input type="submit" value="Зберегти зміни" /></div></div>
                </div>
            </div>
        </form>
    )
}

export default UserSettings;