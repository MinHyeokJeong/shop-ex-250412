import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/deliveries',
      component: () => import('../components/ui/DeliveryGrid.vue'),
    },
    {
      path: '/inventories',
      component: () => import('../components/ui/InventoryGrid.vue'),
    },
  ],
})

export default router;
