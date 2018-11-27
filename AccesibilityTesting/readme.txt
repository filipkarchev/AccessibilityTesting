This app is meant to show how to use accessibility services in Android.
In particular, this app listen to events on the "gauss-calc" app.

After installing this app in the device/emulator, please go in the system preferences and "enable" accessibility features for this app.

Then open gauss-call and try accessibility features:
- When a button is clicked in gauss-calc, the accessibility service is intercepting this event and it prints a toast message to log the printed key.
- Each time the key "1" is pressed, the accessibility service presses the "=" key in gauss-calc