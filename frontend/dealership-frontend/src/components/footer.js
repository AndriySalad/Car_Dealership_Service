import logo from "../img/logo4.png"
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTelegram, faInstagram, faViber } from "@fortawesome/free-brands-svg-icons";
import { faPhone, faEnvelope, faMapMarkerAlt } from '@fortawesome/free-solid-svg-icons';

function Footer() {
  return (
    <footer>
      <div className="footer-block">
        <h3>Ми в соцмережах</h3>
        <div className="social-icons">
          <a href="#"><FontAwesomeIcon icon={faTelegram} className="i" /></a>
          <a href="#"><FontAwesomeIcon icon={faInstagram} className="i" /></a>
          <a href="#"><FontAwesomeIcon icon={faViber} className="i" /></a>
        </div>
      </div>
      
      <div className="footer-block">
        <div className="logo">
          <a href=""><img src={logo} alt="Your Logo" /></a>
        </div>
      </div>

      <div className="footer-block">
        <h3>Контакти</h3>
        <div className="contacts">
          <ul>
            <li><FontAwesomeIcon icon={faPhone} /> +1 123 456 7890</li>
            <li><FontAwesomeIcon icon={faEnvelope} /> info@example.com</li>
            <li><FontAwesomeIcon icon={faMapMarkerAlt} /> 123 Main Street, Anytown, USA</li>
          </ul>
        </div>
      </div>
    </footer>
  );
}

export default Footer;