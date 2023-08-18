// actions.js
import { createAsyncThunk } from '@reduxjs/toolkit';
import { addPrice } from '../../features/priceSearchSlice';

export const fetchPrice = createAsyncThunk<
    string,
    number
>(
    'priceSearch/fetchPrice',
    async (date, hour, { dispatch }) => {
        try {
            const response = await fetch('your/api/endpoint', {
            });

            const data = await response.json();

            // Dispatch the fetched price to add it to the state
            dispatch(addPrice(data));

            return data;
        } catch (error) {
            throw error;
        }
    }
);
