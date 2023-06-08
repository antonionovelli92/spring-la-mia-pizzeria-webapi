<script>
import axios from 'axios';

export default {
    data() {
        return {
            Pizze: [],
            filter: ''
        };
    },
    computed: {
        filteredPizze() {
            if (this.filter === '') {
                return this.Pizze;
            } else {
                return this.Pizze.filter(pizza => {
                    return pizza.name.toLowerCase().includes(this.filter.toLowerCase());
                });
            }
        }
    },
    methods: {
        getPizze() {
            axios.get('http://localhost:8080/api/v1/pizze')
                .then(response => {
                    this.Pizze = response.data;
                })
                .catch(error => {
                    console.error(error);
                });
        },
        filterPizze() {
            axios.get('http://localhost:8080/api/v1/pizze', {
                params: {
                    filter: this.filter
                }
            })
                .then(response => {
                    this.Pizze = response.data;
                })
                .catch(error => {
                    console.error(error);
                });
        },
        deletePizza(id) {
            axios.delete(`http://localhost:8080/api/v1/pizze/${id}`)
                .then(response => {
                    this.getPizze();
                })
                .catch(error => {
                    console.error(error);
                });
        }
    },
    mounted() {
        this.getPizze();
    }
};
</script>

<template>
    <div>
        <h1>Pizza List</h1>
        <input type="text" v-model="filter" placeholder="Filter by name">
        <button @click="filterPizze">Filter</button>
        <ul>
            <li v-for="pizza in filteredPizze" :key="pizza.id">
                {{ pizza.nome }} - {{ pizza.descrizione }} - {{ pizza.prezzo }}
                <button @click="deletePizza(pizza.id)">Delete</button>
            </li>
        </ul>
    </div>
</template>


