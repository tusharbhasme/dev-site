# Navigation Confirmation

Nothing is more frustrating than loosing the contents of a complex form after accidentally closing a tab or navigating out of a page. To make this less likely to happen, nice web applications will often pop-up a confirmation dialog whenever the user tries to leave a page without saving its changes. GWTP comes built-in with a mechanism to allow exactly that.

Enabling a confirmation message is as simple as calling `placeManager.setOnLeaveConfirmation("Do you really want to leave?")`. For example, you could call this method whenever the user edits something on the page. When the user saves his changes you probably want to disable this confirmation, which you do by calling `placeManager.setOnLeaveConfirmation(null)`.

When a navigation confirmation message is set, a pop-up dialog will be shown whenever the user tries to leave the page. If he decides not to leave, then the current page will stay visible and nothing will be lost.
