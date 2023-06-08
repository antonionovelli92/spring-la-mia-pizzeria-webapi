import { createRouter, createWebHistory } from 'vue-router';
import PizzaList from '../PizzaList.vue';
import CreatePizza from '../CreatePizza.vue';


const routes = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        { path: "/", name: "PizzaList", component: PizzaList },
        { path: '/create', name: 'CreatePizza', component: CreatePizza },
        
    ],
});

export { routes };




