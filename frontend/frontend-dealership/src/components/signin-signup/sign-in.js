import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { loginUser } from "../../store/thunk/auth";
import { useAppDispatch, useAppSelector } from '../../utils/hook/';

import './main.css';
import './util.css';

const LoginPage = () => {
  const navigate = useNavigate();
  const dispatch = useAppDispatch()

  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = (e) => {
    e.preventDefault();
    const Data = {
      email,
      password
    }
    try {
      dispatch(loginUser(Data));
      navigate("/profile");
    }catch(e)
    {
      return e;
    }
  };


  return (
    <div className="limiter">
      <div className="container-login100">
        <div className="wrap-login100">
          <form className="login100-form validate-form" onSubmit={handleLogin}>
            <span className="login100-form-title p-b-26">
              Ласкаво просимо!
            </span>

            <div className="wrap-input100 validate-input">
              <input type="email" className="form-control" value={email} placeholder="Email" onChange={e => setEmail(e.target.value)} />
            </div>

            <div className="wrap-input100 validate-input">
              <span className="btn-show-pass">
                <i className="zmdi zmdi-eye"></i>
              </span>
              <input type="password" className="form-control" value={password} placeholder="Пароль" onChange={e => setPassword(e.target.value)} />
            </div>

            <div className="container-login100-form-btn">
              <div className="wrap-login100-form-btn">
                <div className="login100-form-bgbtn"></div>
                <button className="login100-form-btn" type="submit">
                  Увійти
                </button>
              </div>
            </div>
            <div className="text-center p-t-115">
              <span className="txt1">
                Не маєте ще акаунту?
              </span>

              <Link className="txt2" to="/register">
                Реєстрація
              </Link>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}

export default LoginPage;
