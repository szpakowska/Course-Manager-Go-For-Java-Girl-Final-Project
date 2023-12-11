document.addEventListener("DOMContentLoaded", function() {
    // Pobierz dane z serwera
    fetch('/notification')  //adres endpointu do pobierania danych z serwera
        .then(response => response.json())
        .then(notificationsData => {
            // Tutaj możesz przetwarzać dane, generować HTML itp.
            renderNotifications(notificationsData);
        })
        .catch(error => console.error('Błąd pobierania danych z serwera:', error));
});

function renderNotifications(notificationsData) {
    const notificationsContainer = document.getElementById("notificationsContainer");

    // Sortuj powiadomienia - nieprzeczytane najpierw
    const sortedNotifications = notificationsData.sort((a, b) => (a.isRead === b.isRead) ? 0 : a.isRead ? 1 : -1);

    // Wygeneruj HTML dla każdego powiadomienia
    sortedNotifications.forEach(notification => {
        const notificationDiv = document.createElement("div");
        notificationDiv.classList.add("notification");
        if (!notification.isRead) {
            notificationDiv.classList.add("unread");
        }

        notificationDiv.innerHTML = `
            <h3>${notification.subject}</h3>
            <p>${notification.content}</p>
        `;

        // Obsługa kliknięcia powiadomienia
        notificationDiv.addEventListener("click", function() {
            // Poczekaj 5 sekund, a następnie oznacz jako przeczytane
            setTimeout(() => {
                notification.isRead = true;
                notificationDiv.classList.remove("unread");
            }, 5000);
        });

        notificationsContainer.appendChild(notificationDiv);
    });
}
