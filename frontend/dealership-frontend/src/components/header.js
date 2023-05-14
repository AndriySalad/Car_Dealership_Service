import logo from "../img/logo4.png"


function Header(){
    return (
        <nav className="top-menu">
            <a className="navbar-logo" href="">
                <img src={logo}/>
            </a>
            <ul className="menu-main">
                <li className="active"><a href="">Головна</a></li>
                <li><a href="">Каталог</a></li>
                <li><a href="">Контакти</a></li>
                <li><a href="">Кабінет</a></li>
            </ul>
        </nav>
    );
}

export default Header;