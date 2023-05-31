import React, {useState} from "react";
import { Link, useNavigate } from "react-router-dom";
import { useAppDispatch, useAppSelector } from '../../utils/hook/';
import { registerUser } from "../../store/thunk/auth";


function RegisterPage(){

    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [userName, setUserName] = useState('');
    const [email, setEmail] = useState('');
    const [phone, setPhone] = useState('');
    const [password, setPassword] = useState('');
    const [matchingPassword, setMatchingPassword] = useState('');

    const navigate = useNavigate();
    const dispatch = useAppDispatch()
    

    const handleRegister = async (e) => {
        e.preventDefault();
        const Data = {
            firstName,
            lastName,
            userName,
            email,
            phone,
            password
          }
          try {
            await dispatch(registerUser(Data));
            navigate("/profile");
          }catch(e)
          {
            return e;
          }
    }

    return (
        <div className="limiter">
            <div className="container-login100">
                <div className="wrap-login100">
                <form className="login100-form validate-form" onSubmit={handleRegister}>
                    <span className="login100-form-title p-b-26">
                    Ласкаво просимо!
                    </span>
                    
                    <div className="wrap-input100 validate-input">
                        <input type="firstName" className="form-control" value={firstName} placeholder="Ім'я" onChange={e => setFirstName(e.target.value)} />
                    </div>

                    <div className="wrap-input100 validate-input">
                        <input type="lastName" className="form-control" value={lastName} placeholder="Прізвище" onChange={e => setLastName(e.target.value)} />
                    </div>

                    <div className="wrap-input100 validate-input">
                        <input type="userName" className="form-control" value={userName} placeholder="Нікнейм" onChange={e => setUserName(e.target.value)} />
                    </div>

                    <div className="wrap-input100 validate-input">
                        <input type="email" className="form-control" value={email} placeholder="Email" onChange={e => setEmail(e.target.value)} />
                    </div>

                    <div className="wrap-input100 validate-input">
                        <input type="phone" className="form-control" value={phone} placeholder="Номер телефону" onChange={e => setPhone(e.target.value)} />
                    </div>

                    <div className="wrap-input100 validate-input">
                        <input type="password" className="form-control" value={password} placeholder="Пароль" onChange={e => setPassword(e.target.value)} />
                    </div>
                    <div className="wrap-input100 validate-input">
                        <input type="matchingPassword" className="form-control" value={matchingPassword} placeholder="Підтвердити пароль" onChange={e => setMatchingPassword(e.target.value)} />
                    </div>

                    <div className="container-login100-form-btn">
                    <div className="wrap-login100-form-btn">
                        <div className="login100-form-bgbtn"></div>
                            <button className="login100-form-btn" type="submit">
                                Зареєструватись
                            </button>
                        </div>
                    </div>

                    <div className="text-center p-t-115">
                        <span className="txt1">
                            Вже зареєстровані?
                        </span>

                        <Link className="txt2" to="/login">
                            Увійти
                        </Link>
                    </div>
                </form>
                </div>
            </div>
        </div>
    )
}

export default RegisterPage;