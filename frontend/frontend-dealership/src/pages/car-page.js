import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import PageCar from "../components/about-car";



const CarPage = () => {
    const {id} = useParams();
    const [car, setCar] = useState(null);
    const getCar = async () => {
        await axios.get(`http://localhost:8080/cars/${id}`)
        .then((response) => {
            setCar(response.data)
            
        }).catch(error => console.log(error))
    }
    

    useEffect(() => {
        getCar()
    }, [id])

    if (!car)
    {
        return (<div>wait</div>)
    }
    return(
        <div div className="wp-automobile single-page">
            <PageCar car={car}/>
        </div>
    )
}

export default CarPage;