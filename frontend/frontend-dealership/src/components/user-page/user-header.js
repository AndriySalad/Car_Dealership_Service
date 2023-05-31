import {React, useState, useEffect} from "react";
import { Link, useNavigate } from "react-router-dom";
import { useAppDispatch, useAppSelector } from '../../utils/hook/';
import { getPublicUser, logoutUser } from '../../store/thunk/auth';
import axios from "axios";

const  UserHeader = ({user}) => {
    const navigate = useNavigate();
    const [activeIndex, setActiveIndex] = useState(null);
    const token = sessionStorage.getItem('token')
    

    const onClickItem = (index) => {
        setActiveIndex(index);
    }

    const logOutHandler = async(e) => {
        e.preventDefault();
        sessionStorage.clear();
        navigate("/");
    }


    if (user.role === "ROLE_ADMIN"){
        return(
            <div className="row">
                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <ul className="cs-user-accounts-list">
                        <li onClick={() => onClickItem(0)} className={activeIndex === 0 ? 'active' : ''}><Link to="admin-car-list">Список авто</Link></li>
                        <li onClick={() => onClickItem(1)} className={activeIndex === 1 ? 'active' : ''}><Link to="order-list">Всі замовлення</Link></li>
                        <li onClick={() => onClickItem(2)} className={activeIndex === 2 ? 'active' : ''}><Link to="settings">Налаштування інформації</Link></li>
                        <li onClick={() => onClickItem(3)} className={activeIndex === 3 ? 'active' : ''}><Link to="add-auto">Додати авто</Link></li>
                        <li><Link onClick={logOutHandler}>Вихід</Link></li>
                    </ul>
                </div>
            </div>
        );
    }
    else{
        return(
            <div className="row">
                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <ul className="cs-user-accounts-list">
                        <li onClick={() => onClickItem(1)} className={activeIndex === 1 ? 'active' : ''}><Link to="order-list">Мої замовлення</Link></li>
                        <li onClick={() => onClickItem(2)} className={activeIndex === 2 ? 'active' : ''}><Link to="settings">Налаштування інформації</Link></li>
                        <li><Link onClick={logOutHandler}>Вихід</Link></li>
                    </ul>
                </div>
            </div>
        )   
    }
}

export default UserHeader;