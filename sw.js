const CACHE_NAME = 'winners-for-life-v1';

const FILES_TO_CACHE = [
  './',
  './index.html',
  './manifest.json'
];

self.addEventListener('install', event => {
  event.waitUntil(
    caches.open(CACHE_NAME).then(cache => cache.addAll(FILES_TO_CACHE))
  );
  self.skipWaiting();
});

self.addEventListener('activate', event => {
  event.waitUntil(self.clients.claim());
});

self.addEventListener('fetch', event => {
  event.respondWith(
    caches.match(event.request).then(response => {
      return response || fetch(event.request);
    })
  );
});

// =========================================================
// WEB PUSH REAL — Winners For Life
// =========================================================
self.addEventListener('push', event => {
  let data = {};

  try {
    data = event.data ? event.data.json() : {};
  } catch (e) {
    data = {};
  }

  const title = data.title || 'Winners For Life';
  const body = data.body || 'Tenés una nueva notificación.';
  const viewId = data.viewId || 'noticias';

  const url = new URL(self.registration.scope);
  url.searchParams.set('wflView', viewId);

  event.waitUntil(
    self.registration.showNotification(title, {
      body,
      icon: data.icon || undefined,
      badge: data.badge || undefined,
      tag: data.tag || ('wfl-' + Date.now()),
      renotify: true,
      data: {
        viewId,
        url: url.href
      }
    })
  );
});

self.addEventListener('notificationclick', event => {
  event.notification.close();

  const target =
    event.notification.data?.url ||
    new URL(self.registration.scope).href;

  event.waitUntil((async () => {
    const list = await self.clients.matchAll({
      type: 'window',
      includeUncontrolled: true
    });

    for (const client of list) {
      if ('focus' in client) {
        try {
          await client.navigate(target);
        } catch (e) {}

        return client.focus();
      }
    }

    return self.clients.openWindow(target);
  })());
});
