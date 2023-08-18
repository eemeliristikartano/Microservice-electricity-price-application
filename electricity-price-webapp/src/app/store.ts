import { configureStore, ThunkAction, Action } from '@reduxjs/toolkit';
import priceSearcReducer from '../features/priceSearchSlice';

export const store = configureStore({
  reducer: {
    priceSearch: priceSearcReducer
  },
});

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;
export type AppThunk<ReturnType = void> = ThunkAction<
  ReturnType,
  RootState,
  unknown,
  Action<string>
>;
