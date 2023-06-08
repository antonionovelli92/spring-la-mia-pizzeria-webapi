<script>
import axios from 'axios';
const BaseUri = 'http://localhost:8080/api/v1/pizze';
export default {
    data() {
        return {
            pizza: {
                nome: '',
                descrizione: '',
                prezzo: ''
            }
        };
    },
    methods: {
        createPizza() {
            axios.post('http://localhost:8080/api/v1/pizze', this.pizza)
                .then(response => {
                    // Operazione di creazione completata con successo
                    console.log('Pizza created:', response.data);
                    // Effettua una reindirizzamento a una pagina successiva alla creazione
                    this.$router.push('/');
                })
                .catch(error => {
                    console.error(error);
                });
        }
    }
};
</script>
<template>
    <div>
        <h1>Create Pizza</h1>
        <form @submit.prevent="createPizza">
            <label for="name">Name:</label>
            <input type="text" id="name" v-model="pizza.nome" required>
            <label for="description">Description:</label>
            <textarea id="description" v-model="pizza.descrizione" required></textarea>
            <label for="price">Price:</label>
            <input type="number" id="price" v-model="pizza.prezzo" required>
            <button type="submit">Create</button>
        </form>
    </div>
</template>


