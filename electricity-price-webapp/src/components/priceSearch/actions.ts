// actions.js
import { createAsyncThunk } from '@reduxjs/toolkit';
import { addPrice } from '../../features/priceSearchSlice';
import { PRICE_SEARCH_API } from '../../constants';
import { DateTime } from './dateTime';

export const fetchPrice = createAsyncThunk(
    'priceSearch/fetchPrice',
    async ({ date, hour }: DateTime, { dispatch }) => {
        try {
            const response = await fetch(`${PRICE_SEARCH_API}?date=${date}&hour=${hour}`, {
            });

            const data = await response.json();

            // Dispatch the fetched price to add it to the state
            dispatch(addPrice(data.price, date, hour));

            return data;
        } catch (error) {
            throw error;
        }
    }
);
