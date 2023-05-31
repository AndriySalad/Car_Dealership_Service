import React from "react";
import { Link } from "react-router-dom";

function MemberCard
({
    id,
    img, 
    name, 
    phone, 
    position

}) {
    return(
        <div className="col-lg-3 col-md-3 col-sm-6 col-xs-12">
            <div className="cs-team">
                <div className="cs-media" key={id}>
                    <figure><Link><img src={img} alt="" /></Link></figure>
                    <div className="cs-caption"> <i className="icon-bars cs-top-icon"></i>
                        <ul>
                            <li><Link><i className="icon-facebook2"></i></Link></li>
                            <li><Link><i className="icon-twitter2"></i></Link></li>
                            <li><Link><i className="icon-google4"></i></Link></li>
                            <li><Link><i className="icon-linkedin4"></i></Link></li>
                            <li><Link><i className="icon-youtube"></i></Link></li>
                        </ul>
                    </div>
                </div>
                <div className="cs-text">
                    <h6><Link>{name}</Link></h6>
                    <span>{position}</span> <em><i className="icon-phone4"></i>{phone}</em> </div>
            </div>	
	    </div>
    )
}

export default MemberCard;