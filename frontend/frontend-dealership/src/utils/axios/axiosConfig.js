import axios from "axios";

const token = sessionStorage.getItem('token')

export const instance = axios.create({
    baseURL: "http://localhost:8080",
    withCredentials: true
})

export const authInstance = axios.create({
    baseURL: "http://localhost:8080",
    withCredentials: true,
    timeout: 1000,
})

authInstance.interceptors.request.use(config => {
    config.headers.Authorization = `Bearer ${token}`
    return config
})