import React, {useState, useEffect} from "react";
import WhyChooseUsSection from "../components/about-us/about-us-block"
import AboutUsSubheader from "../components/about-us/about-us-subheader";
import SellInfo from "../components/about-us/sell-info";
import TeamBlock from "../components/about-us/team";
import axios from "axios";

function AboutUsPage(){
    const [stat, setStat] = useState(null);
    const getStat = async () => {
        await axios.get("http://localhost:8080/statistic")
        .then((response) => {
            setStat(response.data)
        }).catch(error => console.log(error))
    }

    useEffect(() => {
        getStat();
    }, [])

    if (!stat){
        return (<div><h1>Wait!</h1></div>)
    }

    return(
        <div div className="wp-automobile">
            <div className="wrapper">
                <AboutUsSubheader/>
                <div className="main-section">
                    <WhyChooseUsSection/>
                    <TeamBlock/>
                    <SellInfo stat={stat}/>
                </div>  
            </div>
        </div>
    )
}

export default AboutUsPage;