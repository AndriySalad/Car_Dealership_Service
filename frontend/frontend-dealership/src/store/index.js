import { configureStore } from '@reduxjs/toolkit'
import authSlice from './slices/auth'


const store = configureStore({
    reducer: {
        auth: authSlice
    },
})

export const AppDispatch = typeof store.dispatch;
export const RootState = store.getState;

export default store