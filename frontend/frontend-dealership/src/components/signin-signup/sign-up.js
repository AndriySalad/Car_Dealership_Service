import React from "react";
import { Link, useNavigate } from "react-router-dom";
import { useFormik } from "formik";
import * as Yup from "yup";
import { loginUser, registerUser } from "../../store/thunk/auth";
import { useAppDispatch, useAppSelector } from '../../utils/hook/';

function RegisterPage() {

    const navigate = useNavigate();
    const dispatch = useAppDispatch()

    const formik = useFormik({
        initialValues: {
        firstName: "",
        lastName: "",
        userName: "",
        email: "",
        phone: "",
        password: "",
        matchingPassword: ""
        },
        validationSchema: Yup.object({
        firstName: Yup.string().required("Обов'язкове поле"),
        lastName: Yup.string().required("Обов'язкове поле"),
        userName: Yup.string().required("Обов'язкове поле"),
        email: Yup.string().email("Некоректний email").required("Обов'язкове поле"),
        phone: Yup.string().required("Обов'язкове поле"),
        password: Yup.string().required("Обов'язкове поле"),
        matchingPassword: Yup.string()
            .oneOf([Yup.ref("password")], "Паролі повинні співпадати")
            .required("Обов'язкове поле")
        }),
        onSubmit: async (values) => {
        try {
            await dispatch(registerUser(values));
            navigate("/profile");
        } catch (error) {
            console.log(error);
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
                    type="text"
                    className={`form-control ${formik.errors.firstName ? "is-invalid" : ""}`}
                    placeholder="Ім'я"
                    {...formik.getFieldProps("firstName")}
                />
                {formik.errors.firstName && (
                    <div className="invalid-feedback">{formik.errors.firstName}</div>
                )}
                </div>

                <div className="wrap-input100 validate-input">
                <input
                    type="text"
                    className={`form-control ${formik.errors.lastName ? "is-invalid" : ""}`}
                    placeholder="Прізвище"
                    {...formik.getFieldProps("lastName")}
                />
                {formik.errors.lastName && (
                    <div className="invalid-feedback">{formik.errors.lastName}</div>
                )}
                </div>

                <div className="wrap-input100 validate-input">
                <input
                    type="text"
                    className={`form-control ${formik.errors.userName ? "is-invalid" : ""}`}
                    placeholder="Нікнейм"
                    {...formik.getFieldProps("userName")}
                />
                {formik.errors.userName && (
                    <div className="invalid-feedback">{formik.errors.userName}</div>
                )}
                </div>

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
                <input
                    type="text"
                    className={`form-control ${formik.errors.phone ? "is-invalid" : ""}`}
                    placeholder="Номер телефону"
                    {...formik.getFieldProps("phone")}
                />
                {formik.errors.phone && (
                    <div className="invalid-feedback">{formik.errors.phone}</div>
                )}
                </div>

                <div className="wrap-input100 validate-input">
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

                <div className="wrap-input100 validate-input">
                <input
                    type="password"
                    className={`form-control ${
                    formik.errors.matchingPassword ? "is-invalid" : ""
                    }`}
                    placeholder="Підтвердити пароль"
                    {...formik.getFieldProps("matchingPassword")}
                />
                {formik.errors.matchingPassword && (
                    <div className="invalid-feedback">{formik.errors.matchingPassword}</div>
                )}
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
                <span className="txt1">Вже зареєстровані?</span>
                <Link className="txt2" to="/login">
                    Увійти
                </Link>
                </div>
            </form>
            </div>
        </div>
        </div>
    );
}

export default RegisterPage;
