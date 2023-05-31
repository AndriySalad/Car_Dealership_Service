import { createAsyncThunk } from '@reduxjs/toolkit'
import { instance, authInstance } from '../../../utils/axios/axiosConfig'

export const loginUser = createAsyncThunk(
    'auth/authenticate',
    async (data, { rejectWithValue }) => {
        try {
            const user = await instance.post('auth/authenticate', data)
            if (
                user.data.status === 400 ||
                user.data.status === 401 ||
                user.data.status === 500
            )
                return
            sessionStorage.setItem('token', user.data.access_token)
            sessionStorage.setItem('name', user.data.user.email)
            return user.data
        } catch (error) {
            if (error.response && error.response.data.message) {
                return rejectWithValue(error.response.data.message)
            } else {
                return rejectWithValue(error.message)
            }
        }
    },
)

export const registerUser = createAsyncThunk(
    'auth/register',
    async (data, { rejectWithValue }) => {
        try {
            const user = await instance.post('auth/register', data)
            sessionStorage.setItem('token', user.data.access_token)
            sessionStorage.setItem('name', user.data.user.email)
            return user.data
        } catch (error) {
            if (error.response && error.response.data.message) {
                return rejectWithValue(error.response.data.message)
            } else {
                return rejectWithValue(error.message)
            }
        }
    },
)



