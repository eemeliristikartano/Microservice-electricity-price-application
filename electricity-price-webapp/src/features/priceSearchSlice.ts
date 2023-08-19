import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { RootState } from "../app/store";

interface PriceSearchState {
    prices: Price[]
}

interface Price {
    price: number
    date: string
    hour: number
}

const initialState: PriceSearchState = {
    prices: []
}

export const priceSearchSlice = createSlice({
    name: "priceSearch",
    initialState,
    reducers: {
        addPrice: {
            reducer(state, action: PayloadAction<Price>) {
                state.prices = state.prices.concat(action.payload);
            },
            prepare: (price: number, date: string, hour: number) => {
                return { payload: { price, date, hour } };
            }
        }
    }

});

/*
(state, action: PayloadAction<Price>) => {
            state.prices = state.prices.concat(action.payload)
        }
*/

export const { addPrice } = priceSearchSlice.actions;

export const selectAllPrices = (state: RootState) => state.priceSearch.prices;

export default priceSearchSlice.reducer;