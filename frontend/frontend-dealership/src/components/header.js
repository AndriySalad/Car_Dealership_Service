import React, { useState } from "react";
import { Link } from "react-router-dom";
import logo from "../images/logo.png"


function Header() {


  return (
    <header id="header">
      <div className="container">
        <div className="row">
          <div className="col-lg-2 col-md-2 col-sm-12 col-xs-12">
          </div>
          <div className="col-lg-10 col-md-10 col-sm-12 col-xs-12">
            <div className="cs-main-nav pull-right">
              <nav className="main-navigation">
                <ul className={`menu`}>
                  <li>
                    <Link to="/">Головна</Link>
                  </li>
                  <li>
                    <Link to="/about-us">Про нас</Link>
                  </li>
                  <li>
                    <Link to="/catalog">Каталог</Link>
                  </li>
                  <li>
                      <Link to="/profile">
                        <i className="icon-user2"></i> Кабінет
                      </Link>
                  </li>
                </ul>
              </nav>
            </div>
          </div>
        </div>
      </div>
    </header>
  );
}

export default Header;
