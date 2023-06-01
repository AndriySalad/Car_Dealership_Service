import React from "react";
import { Link } from "react-router-dom";


const footerStyles = {
  footer: {
    background: "#19171a",
    padding: "32px 0 0",
    flexShrink: "0",
    bottom: "0"
  },
  footerWidgets: {
    background: "#141215",
    paddingTop: "37px",
    paddingBottom: "37px",
  },
  widgetSectionTitle: {
    color: "#fff !important",
  },
};

const scrollToTop = () => {
  window.scrollTo({
    top: 0,
    behavior: "smooth",
  });
};

const Footer = () => {
  return (
    <footer id="footer" style={footerStyles.footer}>
      <div className="cs-footer-widgets">
        <div className="container">
          <div className="row">
            <div className="col-lg-3 col-md-3 col-sm-6 col-xs-12">
              <div className="widget widget-categores">
                <div className="widget-section-title">
                  <h6 style={footerStyles.widgetSectionTitle}>Меню</h6>
                </div>
                <ul>
                  <li>
                    <Link to="/">Головна</Link>
                  </li>
                  <li>
                    <Link to="/catalog">Каталог</Link>
                  </li>
                  <li>
                    <Link to="/about-us">Про нас</Link>
                  </li>
                  <li>
                    <Link to="/profile">Кабінет</Link>
                  </li>
                </ul>
              </div>
            </div>
            <div className="col-lg-3 col-md-3 col-sm-6 col-xs-12">
              <div className="widget widget-news-letter">
                <div className="cs-social-media">
                  <ul>
                    <li>
                      <a href="#" data-original-title="facebook">
                        <i className="icon-facebook-f"></i>
                      </a>
                    </li>
                    <li>
                      <a href="#" data-original-title="twitter">
                        <i className="icon-twitter4"></i>
                      </a>
                    </li>
                    <li>
                      <a href="#" data-original-title="linkedin">
                        <i className="icon-linkedin22"></i>
                      </a>
                    </li>
                    <li>
                      <a href="#" data-original-title="google">
                        <i className="icon-google-plus"></i>
                      </a>
                    </li>
                    <li>
                      <a href="#" data-original-title="rss">
                        <i className="icon-rss"></i>
                      </a>
                    </li>
                    <li>
                      <a href="#" data-original-title="vimeo">
                        <i className="icon-vimeo"></i>
                      </a>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div className="cs-copyright" style={footerStyles.footerWidgets}>
        <div className="container">
          <div className="row">
            <div className="col-lg-6 col-md-6 col-sm-12 col-xs-12">
              <div className="cs-back-to-top">
                <address>
                  <i className="icon-phone"></i>{" "}
                  <a href="#">+0 (123) 456-789-10</a>
                </address>
                <button className="btn-to-top cs-bgcolor" onClick={scrollToTop}>
                  <i className="icon-keyboard_arrow_up"></i>
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
