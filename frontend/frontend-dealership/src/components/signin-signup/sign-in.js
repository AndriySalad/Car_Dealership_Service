import React from "react";
import { Link, useNavigate } from "react-router-dom";
import { useFormik } from "formik";
import * as Yup from "yup";
import { loginUser } from "../../store/thunk/auth";
import { useAppDispatch } from '../../utils/hook/';

import './main.css';
import './util.css';

const LoginPage = () => {
  const navigate = useNavigate();
  const dispatch = useAppDispatch();

  const formik = useFormik({
    initialValues: {
      email: "",
      password: ""
    },
    validationSchema: Yup.object({
      email: Yup.string().email("Некоректний email.").required("Введіть будь-ласка email"),
      password: Yup.string().required("Введіть пароль.")
    }),
    onSubmit: async (values) => {
      try {
        await dispatch(loginUser(values));
        navigate("/profile");
      } catch (error) {
        formik.setFieldError("password", "Не вдалось увійти. Будь ласка перевірте правильність введення своїх даних.");
      }
    }
  });

  return (
    <div className="limiter">
      <div className="container-login100">
        <div className="wrap-login100">
          <form className="login100-form validate-form" onSubmit={formik.handleSubmit}>
            <span className="login100-form-title p-b-26">
              Ласкаво просимо!
            </span>

            <div className="wrap-input100 validate-input">
              <input
                type="email"
                className={`form-control ${formik.errors.email ? "is-invalid" : ""}`}
                placeholder="Email"
                {...formik.getFieldProps("email")}
              />
              {formik.errors.email && (
                <div className="invalid-feedback">{formik.errors.email}</div>
              )}
            </div>

            <div className="wrap-input100 validate-input">
              <span className="btn-show-pass">
                <i className="zmdi zmdi-eye"></i>
              </span>
              <input
                type="password"
                className={`form-control ${formik.errors.password ? "is-invalid" : ""}`}
                placeholder="Пароль"
                {...formik.getFieldProps("password")}
              />
              {formik.errors.password && (
                <div className="invalid-feedback">{formik.errors.password}</div>
              )}
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
            {formik.errors.password && (
              <div className="text-center text-danger mt-2">{formik.errors.password}</div>
            )}
          </form>
        </div>
      </div>
    </div>
  );
}

export default LoginPage;
