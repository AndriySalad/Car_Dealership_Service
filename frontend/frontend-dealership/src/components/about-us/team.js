import React from "react";
import MemberCard from "./member-card";
import img1 from "../../images/member-1.jpg"
import img2 from "../../images/member-2.jpg"
import img3 from "../../images/member.png"


function TeamBlock(){
	const teamList = [
		{
			id: 0,
			img: img1,
			name: "Андрій Саладь",
			phone: "8-800-555-3555",
			position: "Developer"
		},
		{
			id: 1,
			img: img2,
			name: "Pyro",
			phone: "8-800-555-3555",
			position: "Головна шиза"
		},
		{
			id: 2,
			img: img3,
			name: "Не відомий",
			phone: "8-800-555-3555",
			position: "Developer"
		},
		{
			id: 3,
			img: img3,
			name: "Не відомий",
			phone: "8-800-555-3555",
			position: "Developer"
		}
	]
    return(
        <div className="page-section" id="page-section-5">
			<div className="container">
				<div className="row">
					<div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div className="section-title" id="team-title">
							<h2>Наша команда</h2>
							<p>Дружній і приємний колектив нашого автосалону завжди радий допомогти вам у вирішенні ваших питань.</p>
						</div>
					</div>
					{teamList.map((obj) => (
						<MemberCard 
							id={obj.id} 
							img={obj.img} 
							name={obj.name} 
							phone={obj.phone} 
							position={obj.position} 
						/>
					))}
				</div>
			</div>
		</div>
    )
}

export default TeamBlock;